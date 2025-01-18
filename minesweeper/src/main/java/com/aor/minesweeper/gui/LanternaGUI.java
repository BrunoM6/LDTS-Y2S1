package com.aor.minesweeper.gui;

import com.aor.minesweeper.model.game.board.Board;
import com.aor.minesweeper.model.game.elements.Cell;
import com.aor.minesweeper.model.game.elements.ClockModel;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;


public class LanternaGUI implements GUI {
    private final Screen screen;
    public LanternaGUI(Screen screen,Board board) {
        this.screen = screen;
    }
    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);

    }
    private Screen createScreen(Terminal terminal) throws IOException{
        final Screen screen1;
        screen1 = new TerminalScreen(terminal);
        screen1.setCursorPosition(null);
        screen1.startScreen();
        screen1.doResizeIfNecessary();
        return screen1;
    }
    private Terminal createTerminal(int col, int row , AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(col, row);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }
    private AWTTerminalFontConfiguration loadFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }
    public void drawBackground(){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.fill(' ');
    }
    @Override
    public void drawCell(Cell cell, int col, int row,Board board, boolean isselected) {
        char displayChar = '-';
        String color = "#000000";
        if (cell.isRevealed()) {
            if (cell.isMine()) {
                displayChar = '*';
                color = "#FF0000";
            } else {
                displayChar = (char) ('0' + cell.getAdjacentMines());
                color = "#000000";
            }
        } else if (cell.isFlagged()) {
            displayChar = 'F';
            color = "#FF0000";
        }
        String text = Character.toString(displayChar);
        int boardStartRow = row + (screen.getTerminalSize().getRows() - board.getHeight()) / 2;
        int boardStartCol = col + (screen.getTerminalSize().getColumns() - board.getWidth()) / 2;
        drawText(boardStartCol,boardStartRow, text,"#FFFFFF",isselected?  "#d3d3d3" : color);

    }

    @Override
    public void drawClock(ClockModel clock,Board board) {
        String text = Integer.toString(clock.getSeconds());
        int width = screen.getTerminalSize().getColumns()/2 + board.getWidth()/2-3;
        int height = screen.getTerminalSize().getRows()/2 - board.getHeight()/2-4;
        drawText(width,height,text,"#FFFFFF", "#FFD700");
    }
    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;
        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'f') return ACTION.FLAG;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'r') return ACTION.RESTART;
        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;
    }
    public void drawText(int x, int y, String text, String BackColor,String ForeColor) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setBackgroundColor(TextColor.Factory.fromString(BackColor));
        tg.setForegroundColor(TextColor.Factory.fromString(ForeColor));
        tg.putString(x, y, text);
    }
    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}

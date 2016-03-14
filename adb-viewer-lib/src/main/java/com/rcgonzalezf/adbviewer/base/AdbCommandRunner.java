package com.rcgonzalezf.adbviewer.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AdbCommandRunner {

    private static final String ADB = "adb";
    private final String subCommand;
    private final List<String> command;
    private final CommandListener<String, IOException> commandListener;

    public AdbCommandRunner(CommandListener<String, IOException> commandListener, String subCommand, final List<String> params) {
        this.subCommand = subCommand;
        this.commandListener = commandListener;
        this.command = new ArrayList<>(params.size() + 2);
        prepareCommand(subCommand, params);
    }

    private void prepareCommand(String subCommand, List<String> params) {
        command.add(ADB);
        command.add(subCommand);
        command.addAll(params);
    }

    public void execute() {

        ProcessBuilder builder = new ProcessBuilder(command);
        Map<String, String> env = builder.environment();

        final Process process;
        try {
            process = builder.start();
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line, allLines = "";

            while ((line = br.readLine()) != null) {
                allLines += line;
            }

            commandListener.onSuccess(allLines);
        } catch (IOException e) {
            e.printStackTrace();
            commandListener.onFailure(e);
        }

    }
}

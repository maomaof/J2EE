package com.pbz.demo.hello.util;

import java.io.File;

public final class ExecuteCommand {

	public static boolean executeCommand(String command, String[] args) throws Exception {
		return executeCommand(command, args, null, null);
	}

	public static boolean executeCommand(String command, String[] args, String[] env, String logFilePath)
			throws Exception {
		final File startIn = new File(command).getParentFile();
		String[] cmds = new String[args.length + 1];
		cmds[0] = command;
		for (int i = 0; i < args.length; i++) {
			cmds[i + 1] = args[i];
		}
		return executeCommand(cmds, env, startIn, logFilePath);
	}

	public static boolean executeCommand(String[] commands, String[] env, File startIn, String logFilePath)
			throws Exception {
		Runtime runtime = Runtime.getRuntime();
		final Process childProcess;
		try {
			childProcess = runtime.exec(commands, env, startIn);
			runtime.addShutdownHook(new Thread() {
				public void run() {
					if (childProcess != null)
						childProcess.destroy();
				}
			});
			StreamReader errorStream = new StreamReader(childProcess.getErrorStream(), "STDERR", logFilePath);
			StreamReader outputStream = new StreamReader(childProcess.getInputStream(), "STDOUT", logFilePath);
			errorStream.start();
			outputStream.start();
			childProcess.waitFor();
			if (childProcess.exitValue() != 0)
				throw new Exception("Runtime execution failed with child process \"" + commands[0] + "\" exit code of "
						+ childProcess.exitValue());
		} catch (Exception e) {
			throw new Exception(e);
		}
		return true;
	}

}

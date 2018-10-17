package baseUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

	public static String OutputFileName = "MyLogDetail"+getDateTimeByFormat(new Date(), "yyyyMMdd_HHmmss");
	private static OutputStreamWriter outputStreamWriter;
	private static String logFileName;
	public static boolean LogFlag = true;

	public Logger() {

	}

	private static void WriteLog(String logEntry) {

		try {

			// 定义log文件名称和路径
			logFileName = ".\\Log" + "\\" + OutputFileName + ".log";
			if (outputStreamWriter == null) {
				File logFile = new File(logFileName);

				if (!logFile.exists())
					logFile.createNewFile();
				// 利用OutputStreamWriter往日志文件写内容
				outputStreamWriter = new OutputStreamWriter(new FileOutputStream(logFileName), "utf-8");
			}
			outputStreamWriter.write(logEntry, 0, logEntry.length());
			outputStreamWriter.flush();

		} catch (Exception e) {
			System.out.println(LogType.LogTypeName.ERROR.toString() + ": Failed to write the file " + logFileName);
			e.printStackTrace();

		}

	}

	// 获取当前系统时间，并格式化输出时间
	private static String getDateTimeByFormat(Date date, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}

	public static void Output(LogType.LogTypeName logTypeName, String logMessage) {

		Date date = new Date();
		String logTime = getDateTimeByFormat(date, "yyyy-MM-dd HH:mm:ss.SSS");
		String logEntry = logTime + " " + logTypeName.name() + ": " + logMessage + "\r\n";
		System.out.print(logEntry);
		// 通过开关控制日志输出，一般我们设置true
		if (LogFlag)
			WriteLog(logEntry);
	}
}
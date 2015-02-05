package org.usfirst.frc.team2022.robot;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class RobotUtils {
	private static Constructor<?> constructDirectByteBuffer;
	private static Field bufferAddressField;

	static {
		try {
			Class<?>[] cArg = new Class[2];
			cArg[0] = long.class;
			cArg[1] = int.class;
			constructDirectByteBuffer = Class.forName(
					"java.nio.DirectByteBuffer").getDeclaredConstructor(cArg);
			constructDirectByteBuffer.setAccessible(true);

			bufferAddressField = Buffer.class.getDeclaredField("address");
			bufferAddressField.setAccessible(true);
		} catch (ReflectiveOperationException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static ByteBuffer newDirectByteBuffer(long addr, int cap) {
		try {
			return ((ByteBuffer) (constructDirectByteBuffer.newInstance(addr,
					cap))).order(ByteOrder.nativeOrder());
		} catch (ReflectiveOperationException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static long getByteBufferAddress(ByteBuffer bb) {
		try {
			return bufferAddressField.getLong(bb);
		} catch (IllegalAccessException e) {
			return 0;
		}
	}
}

package demo;

import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 EMS ems = new EMS();
		 System.out.println(ems.addABC("Gemalto"));

		try {
			Class<?> clazz = Class.forName("demo.EMS");
			Object object = clazz.newInstance();
			// Method[] methods = clazz.getMethods();
			// for (Method method : methods) {
			// System.out.println(method);
			// }

			Method method = clazz.getMethod("addABC", String.class);
			System.out.println(method.invoke(object, "renchu"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

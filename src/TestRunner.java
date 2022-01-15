import java.lang.reflect.*;

public class TestRunner {
	 
    /**
    * Запускает в объекте testSuite все нестатические методы без аргументов, помеченные аннотацией @Test
    .
    */
    public void runTests(Object testSuite) {
		Class testClass = testSuite.getClass();
		for (Method method : testClass.getDeclaredMethods()) {
			boolean isNeedAnnotation = method.isAnnotationPresent(Test.class); 
			boolean isNonStatic = ((method.getModifiers() & Modifier.STATIC) <= 0) ? true : false; 
			boolean hasNotArguments = (method.getParameters().length == 0) ? true : false;
			
			if (isNeedAnnotation && isNonStatic && hasNotArguments) {
				try {
					method.invoke(testSuite);
				} catch (InvocationTargetException e) {
					System.out.println("ошибка в самом методе " + method.getName());
				} catch (IllegalAccessException e) {
					System.out.println("ошибка доступа к методу " + method.getName());
				}
			}
		}

    }
}

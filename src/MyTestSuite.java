public class MyTestSuite {
    @Test
    public static void a() {} // не будет запущен - статический
    
    @Test
    public void b(int a) {} // не будет запущен - есть аргумент
    
    public void c() {} // не будет запущен - нет аннотации
    
    @Test
    public void d() {
		System.out.println("Pabotaem!");
	} // будет запущен
} 

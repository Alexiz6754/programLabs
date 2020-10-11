public class M{
	
	public static final String RESET = "\u001B[0m";
	public static final String BLACK = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String PURPLE = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";
	//ANSI стандарты для цветов
	
	public static void main(String[] args){
		short[] d = new short[7];
		for (int i = 0;i < 7;++i)
			d[i] = (short)(19 - 2*i);
		//Просто чтобы не писать ручками
		float[] x = new float[11];
		for (int i = 0;i < 11;++i)
			x[i] = (float)(Math.random() * 10 - 3);
		//Так как random() возвращает 0..1, то домножим на 10 и отнимем 3, чтобы получить -3..7
		double[][] arr = new double[7][11];
		for (int i = 0;i < 7;++i){
			for (int j = 0;j < 11;++j){
				if (d[i] == 15)
					arr[i][j] = Math.exp((5/Math.abs(x[j])+1)+1);
				else if (d[i] == 7 || d[i] == 9 || d[i] == 19)
					arr[i][j] = Math.exp(Math.log(Math.tan(Math.exp(Math.abs(x[j]))))/3);
					//При Math.pow(1/3) будет возвращать 1, здесь могут быть NaN/infinity (0 возвращает тангенс))
				else
					arr[i][j] = Math.asin(Math.sin(Math.pow(Math.pow(Math.E,Math.tan(x[j])),4/(Math.pow(Math.pow(x[j]/2,3),1/3)+0.25))));	
					//Все верно, но может улететь к довольно большому числу из-за возведения в большую степень
			}
		}
		//Счет всего и вся
		System.out.format(BLUE);
		for (int i = 0;i < 11; ++i)
			System.out.format("%16d",(i+1));
			//Вывод номеров колонок для таблички
		printLine();
		for (int i = 0;i < 7;++i){
			System.out.print(String.format(BLUE) + (i+1) + "     ");
			for (int j = 0;j < 11;++j){
				if (i+j <= 3)
					System.out.print(RED);
				else if (i+j <= 6)
					System.out.print(YELLOW);
				else if (i+j <= 9)
					System.out.print(GREEN);
				else if (i+j <= 12)
					System.out.print(CYAN);
				else 
					System.out.print(PURPLE);
				//Задаем цвета радуги
					if (arr[i][j] > 1000000)
						System.out.printf("|%15.4e",arr[i][j]);
					else
						System.out.printf("|%15.4f",arr[i][j]);
				//Форматированный вывод (Выравнивание по правому краю 15 символов, и вывод 4 знаков после запятой
				//Если число сильно большое, выводим его в экспоненциальной записи
			}
			System.out.println();
		}

		System.out.print(BLUE);
		printLine();
		System.out.print(RESET);
		//Красивенький вывод
	}

	public static void printLine(){
		System.out.println();
		for (int i = 0;i < 12*16-7;++i)//Число выбрано таким, чтобы влазило на экран моего ноута
			System.out.print("-");
		System.out.println();
	}

}

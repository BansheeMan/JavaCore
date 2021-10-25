import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    private static Integer newRed;
    private static Integer newGreen;
    private static Integer newBlue;
    private static Integer newAlfa;

    private static Integer indRed = 0;
    private static Integer indGreen = 1;
    private static Integer indBlue = 2;
    private static Integer indAlfa = 3;


    public static void main(String[] args) {
        try {
            // Открываем изображение
            File file = new File("C:\\Users\\alkli\\Desktop\\GraficaBNTU\\katana.jpg");
            BufferedImage source = ImageIO.read(file);

            //writePixelImage(source); //метод считывает наши пиксели и записывает их в "C:\Users\alkli\\Desktop\GraficaBNTU\notes.txt

            readPixelImage(source); //метод считывает пиксели из нашего "C:\Users\alkli\\Desktop\GraficaBNTU\notes.txt и создает новую картинку идентичную

            //readPixelImageHalf(source); ////метод считывает пиксели из нашего "C:\Users\alkli\\Desktop\GraficaBNTU\notes.txt и создает новую картинку на половину черную

        } catch (IOException e) {
            // При открытии и сохранении файлов, может произойти неожиданный случай.
            // И на этот случай у нас try-catch
            System.out.println("Файл не найден или не удалось сохранить");
        }
    }

    public static void writePixelImage(BufferedImage source) throws IOException {
        // Открываем поток для записи в текстовый файл
        FileOutputStream fos = new FileOutputStream("C:\\Users\\alkli\\Desktop\\GraficaBNTU\\notes.txt");

        // Делаем двойной цикл, чтобы обработать каждый пиксель
        for (int x = 0; x < source.getWidth(); x++) {
            for (int y = 0; y < source.getHeight(); y++) {

                // Получаем цвет текущего пикселя
                Color color = new Color(source.getRGB(x, y));

                // Получаем каналы этого цвета
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                int alfa = color.getAlpha();

                //Открываем поток для записи в текстовый файл
                //Преобразуем каналы цвета в строку и записываем по байтам
                String str = red+" "+green+" "+blue+" "+alfa+"\n";
                byte[] buffer = str.getBytes();
                fos.write(buffer, 0, buffer.length);
            }
        }
        //Закрываем поток записи нашего txt.
        fos.close();
    }

    public static void readPixelImage(BufferedImage source) throws IOException {
        // Создаем новое пустое изображение, такого же размера
        BufferedImage result = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
        //Создаем поток для чтения нашего .txt
        FileReader reader = new FileReader("C:\\Users\\alkli\\Desktop\\GraficaBNTU\\notes.txt");
        Scanner scan = new Scanner(reader);

        //Создаем коллекцию и записываем в нее каналы для каждого нашего пикселя
        List<Integer> numbers = new ArrayList<>();
        while (scan.hasNextLine()) {
            String newStr = scan.nextLine();
            StringTokenizer st;
            st = new StringTokenizer(newStr, " ");
            while (st.hasMoreTokens()) {
                numbers.add(Integer.parseInt(st.nextToken()));
            }
        }
        //Закрываем поток для чтения нашего .txt
        reader.close();

        //Проходимся по каждому пикселю нашего изображения
        for (int x = 0; x < source.getWidth(); x++) {
            for (int y = 0; y < source.getHeight(); y++) {
                //Устанавливаем значение для каждого канал нашего пикселя
                newRed = numbers.get(indRed);
                newGreen = numbers.get(indGreen);
                newBlue = numbers.get(indBlue);
                newAlfa = numbers.get(indAlfa);

                //Cоздаем новый цвет
                Color newColor = new Color(newRed, newGreen, newBlue, newAlfa);
                //И устанавливаем этот цвет в текущий пиксель результирующего изображения
                result.setRGB(x, y, newColor.getRGB());

                //Переопределяем значение для каждого канала нашего следующего пикселя
                indRed = indRed + 4;
                indGreen = indGreen + 4;
                indBlue = indBlue + 4;
                indAlfa = indAlfa + 4;
            }
        }
        //Созраняем результат в новый файл
        File output = new File("C:\\Users\\alkli\\Desktop\\GraficaBNTU\\katana2.jpg");
        ImageIO.write(result, "jpg", output);
    }

    //------------------------------------------------------------------------------------------------------------------

    public static void readPixelImageHalf(BufferedImage source) throws IOException {
        BufferedImage result = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
        FileReader reader = new FileReader("C:\\Users\\alkli\\Desktop\\GraficaBNTU\\notes.txt");
        Scanner scan = new Scanner(reader);

        List<Integer> numbers = new ArrayList<>();
        while (scan.hasNextLine()) {
            String newStr = scan.nextLine();
            StringTokenizer st;
            st = new StringTokenizer(newStr, " ");
            while (st.hasMoreTokens()) {
                numbers.add(Integer.parseInt(st.nextToken()));
            }
        }
        reader.close();
        //Все аналогично методу readPixelImageHalf за исключением того, что обрабатываем только половину всех пикселей
        for (int x = 0; x < (source.getWidth()/2); x++) {
            for (int y = 0; y < source.getHeight(); y++) {

                newRed = numbers.get(indRed);
                newGreen = numbers.get(indGreen);
                newBlue = numbers.get(indBlue);
                newAlfa = numbers.get(indAlfa);

                Color newColor = new Color(newRed, newGreen, newBlue, newAlfa);
                result.setRGB(x, y, newColor.getRGB());

                indRed = indRed + 4;
                indGreen = indGreen + 4;
                indBlue = indBlue + 4;
                indAlfa = indAlfa + 4;
            }
        }
        File output = new File("C:\\Users\\alkli\\Desktop\\GraficaBNTU\\katana2.jpg");
        ImageIO.write(result, "jpg", output);
    }
}

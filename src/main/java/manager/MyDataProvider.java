package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {
    @DataProvider
    public Iterator<Object[]>loginValidData() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"noa@gmail.com","Nnoa12345$"});
        list.add(new Object[]{"noa@gmail.com","Nnoa12345$"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> ContactValidData() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader((new FileReader("C:\\Users\\vanan\\Desktop\\qa telran myproject\\Qa11_PhoneBook\\src\\test\\resources\\Книга1.csv")));
        String line = reader.readLine();
        while (line!=null){
            String []split = line.split(";");
            list.add(new Object[]{Contact.builder()
                    .name(split[0])
                    .lastName(split[1])
                    .phone(split[2])
                    .email(split[3])
                    .address(split[4])
                    .description(split[5])
                    .build()
            });
            line=reader.readLine();
        }
//        list.add(new Object[]{"Hay","Low","1234567890","hay@gmail.com","Haifa","Mother"});
//        list.add(new Object[]{Contact.builder().name("Hay").lastName("Low").email("hay@gmail.com").address("Haifa").description("Mother").build()});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addContactValidDataCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(("src/test/resources/nn.csv")));
        String line = reader.readLine();//Mona,Dow,3214598765,mona@gmail.com,Haifa,friend

        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{Contact.builder()
                    .name(split[0])
                    .lastName(split[1])
                    .phone(split[2])
                    .email(split[3])
                    .address(split[4])
                    .description(split[5])
                    .build()
            });
            line = reader.readLine();
        }
        return list.iterator();
    }

}

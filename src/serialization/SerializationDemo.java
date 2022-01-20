package serialization;

import java.io.*;

public class SerializationDemo {

    public static void main(String[] args) {
        serialize();
        deSerialize();
    }

    private static void deSerialize() {
        try(ObjectInputStream in=new ObjectInputStream(new FileInputStream("f.ser"));
        ){
            MySerializationDemo demo1 = (MySerializationDemo) in.readObject();

            //printing the data of the serialized object
            System.out.println(demo1.getId()+" "+demo1.getName()+ " "+demo1.getSalary());
            //closing the stream
            in.close();
        }catch(Exception e){System.out.println(e);}

    }

    private static void serialize() {
        MySerializationDemo demo = new MySerializationDemo();
        demo.setId("123");
        demo.setName("Pawan");
        demo.setSalary(1000);
        try(FileOutputStream fout=new FileOutputStream("f.ser");
            ObjectOutputStream out=new ObjectOutputStream(fout);  ){

            out.writeObject(demo);
            out.flush();
            //closing the stream
            out.close();
            System.out.println("Serialized success");

        }catch(Exception e){
            System.out.println(e);
        }
    }

}

class MySerializationDemo implements Serializable {

    private String id;
    private String name;

    private transient float salary;

    // Custom serialization logic,
    // This will allow us to have additional serialization logic on top of the default one e.g. encrypting object before serialization
    private void writeObject(ObjectOutputStream oos) throws IOException
    {
        System.out.println("Custom serialization logic invoked.");
        oos.defaultWriteObject(); // Calling the default serialization logic
        //throw new NotSerializableException("Not today!");
    }

    // Custom deserialization logic
    // This will allow us to have additional deserialization logic on top of the default one e.g. decrypting object after deserialization
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException
    {
        System.out.println("Custom deserialization logic invoked.");

        ois.defaultReadObject(); // Calling the default deserialization logic

        //throw new NotSerializableException("Not today!");
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
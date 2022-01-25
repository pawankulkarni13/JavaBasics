package threads;

public class ThreadInterCommunicationDemo {
    public static void main(String[] args) {
        ChatApp chat = new ChatApp();
        new ThreadOne(chat);
        new ThreadTwo(chat);
    }
}

class ChatApp {
    boolean flag = false;

    public synchronized void question(String msg) {
        if (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() +" says - "+msg);
        flag = true;
        notify();
    }
    public synchronized void answer(String msg) {
        if (!flag) {
            try {
                wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() +" says - "+msg);
        flag = false;
        notify();
    }
}
class ThreadOne implements Runnable {
    ChatApp chatApp;
    String[] s1 = { "Hi", "How are you ?", "I am also doing fine!", "Bye !!!" };

    public ThreadOne(ChatApp chatApp) {
        this.chatApp = chatApp;
        new Thread(this, "ThreadOne").start();
    }

    public void run() {
        for (int i = 0; i < s1.length; i++) {
            chatApp.question(s1[i]);
        }
    }
}

class ThreadTwo implements Runnable {
    ChatApp chatApp;
    String[] s2 = { "Hi", "I am good, what about you?", "Great!", "Bye Bye!!" };

    public ThreadTwo(ChatApp chatApp) {
        this.chatApp = chatApp;
        new Thread(this, "ThreadTwo").start();
    }

    public void run() {
        for (int i = 0; i < s2.length; i++) {
            chatApp.answer(s2[i]);
        }
    }
}
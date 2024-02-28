public class Teaching {
    static final String[] CONTENTS = {"Java", "Python", "C"};

    public static void main(String[] args) {
        WhiteBoard wb = new WhiteBoard(CONTENTS.length);
        Teacher teacher = new Teacher(wb);
        Student s1 = new Student(wb, 1);
        Student s2 = new Student(wb, 2);
        Student s3 = new Student(wb, 3);

        new Thread(() -> {
            for (String c : CONTENTS) {
                teacher.teach(c);
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < CONTENTS.length; i++) {
                s1.learn();
            }}).start();
        new Thread(() -> {
            for (int i = 0; i < CONTENTS.length; i++) {
                s2.learn();
            }}).start();
        new Thread(() -> {
            for (int i = 0; i < CONTENTS.length; i++) {
                s3.learn();
            }}).start();
    }
}

class WhiteBoard {
    String content;
    int total;
    int count;

    public WhiteBoard(int total) {
        this.total = total;
        this.count = 0;
    }

    synchronized public void setContent(String c) {
        while(count != 0) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        content = c;
        // BUG: count is not altered
        count = total;
        notifyAll();
    }

    synchronized public String getContent() {
        while (count == 0) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        String t = content;
        if (--count == 0) {
            notify();
        }
        return t;
    }
}

class Teacher {
    WhiteBoard wb;

    public Teacher(WhiteBoard wb) {
        this.wb = wb;
    }

    public void teach(String content) {
        System.out.println("Teacher: " + content);
        wb.setContent(content);
    }
}

class Student {
    WhiteBoard wb;
    int id;

    public Student(WhiteBoard wb, int id) {
        this.wb = wb;
        this.id = id;
    }

    public void learn() {
        String c = wb.getContent();
        System.out.println(id + " Student: " + c);
    }
}
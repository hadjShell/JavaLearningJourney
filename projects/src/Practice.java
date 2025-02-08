public class Practice {
    int j=12;
    void add()
    {
        j=j+12;
        System.out.println("J="+j);
    }

    @Override
    public void finalize()
    {
        System.out.println("Object is garbage collected");
    }

    public static void main(String[] args) throws Exception {
        new Practice().add();
        System.gc();
        new Practice().add();
        System.out.println(Runtime.getRuntime().totalMemory());
    }
}
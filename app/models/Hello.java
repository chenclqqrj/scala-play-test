package models;

/**
 * Created by crjun on 14-4-28.
 */
public class Hello {
    private String word;

    public Hello(String w) {
        this.word = w;
    }

    public void say() {
        System.out.println("---" + word);
    }
}

import java.io.FileWriter;
import java.io.IOException;

public final class buffer {
    private int size = 8; // the buffer bound
    private Object queue[] = new Object[size];
    private int inptr = 0;
    private int outptr = 0;
    semaphore spaces = new semaphore(size);

    semaphore elements = new semaphore(0);
    public void produce(Object value) {
        spaces.P();
        queue[inptr] = value;
        inptr = (inptr + 1) % size;
        elements.V();
    }
    public Object consume() {
        Object value;
        elements.P();
        value = queue[outptr];
        outptr = (outptr + 1) % size;
        spaces.V();
        return value;

    }
}
public class DynamicStack extends CustomStack {
    public DynamicStack() {
        super();
    }

    public DynamicStack(int size) {
        super(size);
    }

    // Pop and peek operations will remain same for static and dynamic stacks.
    @Override
    public boolean push(int item) {
        if (this.isFull()) {
            // Double the array size
            int[] temp = new int[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }

        return super.push(item);
    }
}

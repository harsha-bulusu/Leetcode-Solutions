class FooBar {
    private int n;
    int owner = 1;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized(this) {
                while (owner != 1) wait();
                
                printFoo.run();
                owner = 2;
                notifyAll();
            }
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
            synchronized(this) {
        	    while (owner != 2) wait();
               
                printBar.run();
                owner = 1;
                notifyAll(); 
            }
        }
    }
}

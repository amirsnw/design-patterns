package com.singleton;

/**
 * This class demonstrates singleton pattern using Double Checked Locking or "classic" singleton.
 * This is also a lazy initializing singleton.
 * Although this implementation solves the multi-threading issue with lazy initialization using volatile
 * and double check locking, the volatile keyword is guaranteed to work only after JVMs starting with
 * version 1.5 and later.
 */
public class LazyRegistryDCL {

    private LazyRegistryDCL() {
    	
    }
    
    private static volatile LazyRegistryDCL INSTANCE;
    
    public static LazyRegistryDCL getInstance() { // Double-checked locking
    	if (INSTANCE == null) {
    		synchronized (LazyRegistryDCL.class) { // Taking lock on the entire class
				if (INSTANCE == null) {
					INSTANCE = new LazyRegistryDCL();
				}
			}
    	}
    	return INSTANCE;
    }
}

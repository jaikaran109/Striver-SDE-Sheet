class LFUCache {

    int capacity;
    int minFreq;

    HashMap<Integer, Integer> keyToValue;
    HashMap<Integer, Integer> keyToFreq;
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;

        keyToValue = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
    }
    
    public int get(int key) {
        if(!keyToValue.containsKey(key)) {
            return -1;
        }

        increaseFreq(key);
        return keyToValue.get(key);
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;

        if(keyToValue.containsKey(key)) {
            keyToValue.put(key, value);
            increaseFreq(key);
            return;
        }

        if(keyToValue.size() == capacity) {
            LinkedHashSet<Integer> keys = freqToKeys.get(minFreq);

            int removeKey = keys.iterator().next();

            keys.remove(removeKey);

            keyToValue.remove(removeKey);
            keyToFreq.remove(removeKey);
        }

        keyToValue.put(key, value);
        keyToFreq.put(key, 1);

        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);

        minFreq = 1;
    }

    private void increaseFreq(int key) {
        int oldFreq = keyToFreq.get(key);

        LinkedHashSet<Integer> oldSet = freqToKeys.get(oldFreq);
        oldSet.remove(key);

        if(oldSet.isEmpty() && oldFreq == minFreq) {
            minFreq++;
        }

        int newFreq = oldFreq + 1;

        keyToFreq.put(key, newFreq);

        freqToKeys.putIfAbsent(newFreq, new LinkedHashSet<>());
        freqToKeys.get(newFreq).add(key);
    }
}

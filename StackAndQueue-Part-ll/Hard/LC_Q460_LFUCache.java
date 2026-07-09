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






/*
## Explanation

In this problem, we need to design an LFU Cache.

LFU means Least Frequently Used. So, when the cache becomes full, we need to remove the key which has been used the least number of times.

But there is one more condition. If two or more keys have the same frequency, then we remove the least recently used key among them.

So basically, we have to manage two things:

1. Frequency of every key
2. Recent order of keys having the same frequency

Whenever we call `get(key)`, if the key exists, its frequency increases by 1.

Whenever we call `put(key, value)`, if the key already exists, we update its value and increase its frequency by 1.

If the key does not exist and the cache is full, then we remove the key with the minimum frequency. If multiple keys have the same minimum frequency, we remove the oldest key from that frequency group.

## Approach

To solve this efficiently, we use three maps.

`keyToValue` stores the value of each key.

`keyToFreq` stores the current frequency of each key.

`freqToKeys` stores all keys having the same frequency. For this, we use `LinkedHashSet` because it maintains insertion order. This helps us remove the least recently used key when multiple keys have the same frequency.

We also maintain a variable `minFreq`, which tells us the current minimum frequency present in the cache.

When a key is accessed, we remove it from its old frequency group, increase its frequency, and add it to the new frequency group.

If the old frequency group becomes empty and that frequency was equal to `minFreq`, then we increase `minFreq`.

For inserting a new key, its frequency is always 1, so we set `minFreq = 1`.

This allows both `get()` and `put()` operations to work in O(1) average time.
*/

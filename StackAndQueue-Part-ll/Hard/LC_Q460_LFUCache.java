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

Is problem me hume LFU Cache design karna hai.

LFU ka full form hai Least Frequently Used. Matlab jab cache full ho jaye, to hume us key ko remove karna hai jo sabse kam baar use hui hai.

Agar multiple keys ki frequency same hai, then unme se least recently used key remove hogi.

So is problem me hume two things maintain karni hoti hain:

1. Har key ki frequency
2. Same frequency wali keys ka recent order

Jab bhi `get(key)` call hota hai and key exist karti hai, us key ki frequency 1 se increase ho jaati hai.

Jab bhi `put(key, value)` call hota hai and key already exist karti hai, hum value update karte hain and frequency increase karte hain.

Agar new key insert karni hai and cache full hai, then hum minimum frequency wali key remove karte hain. Agar same minimum frequency me multiple keys hain, then jo key sabse purani hai, vo remove hoti hai.

## Approach

Efficient solution ke liye hum three maps use karte hain.

`keyToValue` key ki value store karta hai.

`keyToFreq` key ki current frequency store karta hai.

`freqToKeys` same frequency wali keys ko store karta hai. Iske liye hum `LinkedHashSet` use karte hain because ye insertion order maintain karta hai. Isse same frequency ke andar least recently used key ko easily remove kar sakte hain.

Ek `minFreq` variable bhi maintain karte hain, jo current cache ki minimum frequency batata hai.

Jab bhi koi key access hoti hai, hum usko old frequency group se remove karte hain, uski frequency increase karte hain, and new frequency group me add kar dete hain.

Agar old frequency group empty ho jata hai and old frequency `minFreq` ke equal thi, then hum `minFreq` ko increase kar dete hain.

New key insert karte time uski frequency always 1 hoti hai, so `minFreq = 1` set kar dete hain.

Is approach se `get()` and `put()` dono operations O(1) average time me ho jaate hain.

*/


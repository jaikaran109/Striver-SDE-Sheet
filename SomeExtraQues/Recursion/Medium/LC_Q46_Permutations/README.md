# Permutations Backtracking Logic & Recursion Tree (`[1, 2, 3]`)

## 1. Recursion Tree Diagram

```text
                                         [1,2,3]
                  /                      |                      \
            i=0, take 1                i=1, take 2              i=2, take 3
             DS: [1]                    DS: [2]                  DS: [3]
          Freq: [T,F,F]              Freq: [F,T,F]            Freq: [F,F,T]
          /           \              /           \            /           \
     i=1, take 2   i=2, take 3  i=0, take 1   i=2, take 3  i=0, take 1   i=1, take 2
       [1, 2]        [1, 3]       [2, 1]        [2, 3]       [3, 1]        [3, 2]
         |             |            |             |            |             |
     i=2, take 3   i=1, take 2  i=2, take 3   i=0, take 1  i=1, take 2   i=0, take 1
     [1, 2, 3]     [1, 3, 2]    [2, 1, 3]     [2, 3, 1]    [3, 1, 2]     [3, 2, 1]
     (Base Hit)    (Base Hit)   (Base Hit)    (Base Hit)   (Base Hit)    (Base Hit)
```

   ## 2. Detailed Step-by-Step Working & Iteration Logic

Yeh backtracking algorithm **Permutations** generate karne ke liye kaam karta hai. Isme har ek recursive call ke paas apna khud ka independent `for-loop` aur execution state hoti hai. Isko ekdum detail mein samajhte hain ki kaise ek-ek karke sari values process hoti hain:

### A. Har Call ka Apna Independent Loop aur State
* Jab hum helper function ko call karte hain, toh har ek level par loop `i = 0` se lekar `nums.length - 1` tak chalta hai.
* Agar maan lijiye ki kisi point par `ds` ke andar kuch elements already present hain (jaise `[1, 3]`), toh us waqt function call ke andar ka loop dobara `0` se nahi balki apne current frame ke hisaab se chal raha hota hai. Lekin `freq[i] == true` hone ki wajah se jo elements pehle se `ds` mein hain, woh skip ho jaate hain.

### B. Backtracking aur State Reset ka Process (Detailed Trace)
Maan lijiye humne `1, 2, 3` ke liye execution shuru kiya:

* **Pehela Path (`[1, 2, 3]` ka banna):**
  * Loop ne sabse pehle `i = 0` par `1` ko pick kiya. `freq[0] = true` ho gaya, aur `ds` ban gaya `[1]`.
  * Uske baad naye recursive call mein loop fir se `0` se start hota hai, par `i = 0` (`1`) visited hone ki wajah se skip ho jata hai. Phir `i = 1` par `2` ko pick karta hai. `freq[1] = true` aur `ds` ho jata hai `[1, 2]`.
  * Phir next recursive call mein `i = 2` par `3` pick hota hai, `ds` ban jata hai `[1, 2, 3]`.
  * Yahan **Base Condition hit** ho jaati hai (`ds.length == nums.length`), kyunki size `3` ho chuki hai. Yeh permutation print/store ho jata hai aur function return karta hai.

* **Wapsi (Backtracking) aur Next Iteration:**
  * Jab `[1, 2, 3]` waale call se return hota hai, toh backtracking steps execute hote hain: `3` ko `ds` se remove kar diya jata hai (`ds.remove()`) aur `freq[2] = false` kar diya jata hai.
  * Ab usi frame mein loop aage badhta hai. Kyunki `i` ki value aakhri index (`2`) par pahuch chuki thi, isliye yeh wala for-loop complete ho jata hai aur yeh frame bhi return ho kar pichle wale frame par chala jata hai.
  * Jab pichle frame par aate hain jahan `ds` mein sirf `[1]` tha, toh wahan `2` remove hota hai (`ds.remove()`) aur `freq[1] = false` ho jata hai.
  * Ab us frame ka loop aage badhta hai aur `i = 2` (`3`) ko pick karta hai. Is tarah se `ds` mein `1` ke baad seedha `3` add ho jata hai, aur `ds` ban jata hai `[1, 3]`.

* **Naye Path ka Banna (`[1, 3, 2]`):**
  * Jab `ds` mein `[1, 3]` hai, toh is waqt `ds.length` ki value `2` hai (jo ki `3` ke barabar nahi hai), isliye base condition yahan **hit nahi hoti**.
  * Jab base condition hit nahi hoti, toh function aage badhta hai aur us frame ke andar ka for-loop bacha hua iteration chalane ke liye aage badhta hai.
  * Loop dobara `0` se check karna shuru karta hai: `i = 0` (`1`) visited hai (skip), `i = 1` (`2`) ka `freq[1]` abhi **false** ho chuka hai (kyunki pichle step mein humne `2` ko remove karke `freq[1] = false` kar diya tha!).
  * Jaise hi `freq[1] == false` milta hai, loop `2` ko utha leta hai aur `ds` mein add kar deta hai. Ab `ds` ban jata hai `[1, 3, 2]`.
  * Ab yeh naya combination agle recursive call mein jata hai, jahan iska size `3` ho jata hai aur yeh doosri base condition ko successfully hit kar leta hai!

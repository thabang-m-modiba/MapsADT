# Maps with Java
* A map is an abstract data type designed to efficiently store and retrieve values based upon a uniquely identifying <b>search key</b> for each.
* Specifically,  a map stores key value pairs $(k, v)$, which we call entries, where $k$ is the key and $v$ is its corresponding value.
* Keys are required to be unique, so that the association of keys to values define a mapping.
* Maps are also known as associative arrays, because the entry's key serves somewhat like an index into the map, in that it assists the map in efficiently locating the associated entry.
* However, unlike a standard array, a key if a map need not be numeric, and it does not directly designate a position within the structure.
* Common applicatio of maps is in DNSs.

## The Map ADT
* As an ADT, a map supports the following operations:
  - <code>size() // Method returns the number of entries in map M</code>
  - <code>isEmpty() // Method returns a boolean indicating whether the mao is empty</code>
  - <code>get(k) // Method returns the value v associated with key k, if such entry exists. Otherwise returns null</code>
  - <code>put(k, v) // If M does not have an entry with key k, then the method adds entry (k, v) to M and return null; else, replace with v the existing value of the entry with key equal to k and return the old value.</code>
  - <code>remove(k) // Method removes from M the entry with key k, and return its value. If M has no such entry, then return null</code>
  - <code>ketSet() // Method returns an iterable collection containing all the keys stored in M</code>
  - <code>values() // Method returns an iterable collection containing all the values of entries stored in M, with repetition of multiple keys map to the same value</code>
  - <code>entrySet() // Method returns an iterable collection containing all the key-value entries in M</code>

## Maps in teh java.util Package
* Map ADT is a simplified version of <code>java.util.Map</code>.
* The <code>java.util.Map</code> relies on the nested <code>java.util.Map.Entry</code> interface.
* Each operation <code>get(k)</code>, <code>put(k, v)</code>, and <code>remove(k)</code> returns the existing values associated with key k, if the map has such an entry, and otherwise returns null.
* This introduces ambiguity in an application for which null is allowed as a natural value associated with a key k.
* That is, if an entry $(k, null)$ ecists in a map, then operation <code>get(k)</code> will return null, not because it couldn't find the key, but because it found the key and is returning its associated value.
* Some implementations of the <code>java.util.Map</code> interface explicitly forbid use of a null value, and null keys.
* However, to resolve the ambiguity when null is allowable, the interface contanins a boolean method, <code>containsKet(k)</code> to definitively check whether k exists as a key.

## 💻 Application: Counting Word Frequencies
* Consider the problem of counting the number of occurances of words in a document.
* A map is an ideal data structure for use here, for we can use words as keys and word counts as values.
* We begin with an empty map, mapping words to their integer frequencies.
* We first scan through the input, considering adjacent alphabetic characters to be words, which we then convert to lowercase/
* For each word found, we attempt to retrieve its current frequency from the map using the get method, with a yet unseen word having frequency zero.
* We then (re)set its frequency to be one more to reflect the current occurance of the word.
* After processing the entire input, we loop through the entrySet() of the map to determine which word has most occurances.
* 📁 <b>Project Folder: </b> [Here](https://github.com/thabang-m-modiba/MapsADT/tree/068646ab703e94c0fa3da96c8e59a241edd024a8/WordCount)

## 💻 Unsorted Map
* An unsorted map is a type of map data structure that stores key-value pairs without maintaining any particular order among keys.
* 📁 <b>Project Folder: </b> [Here](https://github.com/thabang-m-modiba/MapsADT/tree/0cd5d8f38f8230b043445e98936825e7395cf6e4/UnsortedMaps)

## Hash Tables
* A map supports the abstraction of using keys as "addresses" that help locate an entry.
* Consider a restricted setting in which a map with n entries uses keys that are known to be integers in a range from 0 to $N-1$ for some $N>=n$.
* In this case, we can represent a map using a lookup table of length $N$, where we store the value associated with key $k$ at index $k$ of the table, presuming that we have a distinct way to represent an empty slot.
* Basic map operations <code>get, put and remove</code> can be implemented in $O(1)$ worst-case time.
* There are two challenges in extending this framework to the more general setting of a map.
  1. We may not wish to devote an array of length $N$ if it is the case that $N >> n$.
  2. We do not in general require that a map's keys be integers.
* The novel concept of a hash table is the use of a <b>hash function</b> to map general keys to corresponding indices in a table.
* Ideally, keys will be well distributed in the range from 0 to $N - 1$ by a hash function, but in practice there may be two or more distinct keys that get mapped to the same index.
* As a result, we will conceptualize our table as a <b>bucket array</b>, in which each bucket may manage a collection of <b>entries</b> that are sent to a specific index by the hash function.
  * An empty bucket may be replaced by a null reference.

### Hash Functions
* The goal of a hash function, $h$, is to map each key $k$ to an integer in the ranhe $[0, N - 1]$, where $N$ is the capacity of the bucket array for a hash table.
* The main idea of this approach is to use the hash function value, $h(k)$, as an index into out bucket array, A, instead of the key $k$, which may not be appropriate for direct use as an index. That is, we store the entry $(k, v)$ in the bucket $A[h(k)]$.
* If there are two or more keys with the same hash value, then two different entries will be mapped to the same bucket in $A$.
* In this case, we say that a <b>collision</b> has occured.
* There are ways of dealing with collisions, but the best strategy is to try avoid them in the first place.
* A good hash fucntion sufficiently avoids collisions.
* It is common to view the evaluation of a hash function, $h(k)$, as consisting of two portions:
  1. <b>Hash code</b> - maos a key $k$ to an integer.
  2. <b>Compression function</b> - maps the has code to an integer within a range of indices, $[0, N - ]$ for a bucket array.
 
* The advantage of spreading the hash function into rwo such components is that the has code porion of that computation is independent of a specific has table size.
* This allows the development of a general has code for each object that can be used for a has table of any size.
* Only the compression function depends upon the table size.
* This is particularly convinient, because the underlying bucket array for a hash table may be dynamically resized, depending on the number of entries currently stored in the map.

#### Hash Codes
* The first action that a <b>hash function</b> perfoems is to take an arbitrary key $k$ in out map and compute an integer that is called the <b>hash code</b> for $k$.
* This integer need not be in a range $[0, N-1]$, and may even be negative.
* We desire that the set of hash codes assigned to our keys should avoid collisions.
* For if the has codes of our keys cause collisions, then there is no hope for our <b>compression function</b> to avoid them.
* Below are some different approaches to the implementation of has codes:
  - Treating the Bit representation as an integer
  - Polynomial hash codes
  - Cyclic-Shift hash codes
#### Hash Codes in Java
* The notion of hash codes are an internal part of the java language.
* The <code>Object</code> class, which serves as an ancestor of all Object types, includes a default <code>hashCode()</code> method that returns a 32-bit int, which serves as an object's hasg code.
* The default version of <code>hashCode()</code> provided by the Object class is oftern just an integer reprresentation derived from the object's memory.
* However, we must be careful if relying on the default version of <code>hashCode()</code> when authoring a class.
* for hashing schemes to be reliable, it is imperative that any two objects that are viewed as "equal" to each other have the same hash code.
* Thius is important because, if an entry is inserted into a map, and a later search is performed on a key that is considered equivalent to that entry's key, the map must recognize this as a match.
* Therefore, when using a hash table to implement a map, we want equivalent keys to have the same hash code so that they are guaranteed to map to the same bucket.
* More formally, if a class defines equivalence through the equals method, then that class should also provide a consistent implementation of the hashCode method, such that if <code>x.equald(y)</code>, then <code>x.hashCode() == y.hashCode()</code>.

#### Compression Functions
* The hash code for a key $k$ will typically not be suitable for immediate use with a bucket array, because the integer hash code may be negative or may exceed the capacity of the bucket array.
* Thus, once we have determined an integer hash code for a key $k$, there is still the issue of mapping that integer into the range $[0, N-1]$.
* Compression function is the second action performed as part of an obverall hash function.
* A good compression function minimizes the number of collisions.

##### The Division Method
* The devision method is a simple compression function, which maps an integer $i$ to $i mod N$, where $N$, the size of the bucket array, is a fixed positive integer.
* If we take $N$ to be a prime number, then this compression function helps "spread out" the distribution of hashed values.
* If $N$ is not a prime number, then there is a greater risk that patterns in the distribution of hash codes will be repeated in the distribution of hash values, thereby causing collisions.
* If a hash function is choosen well, then it should ensure that the probability of two different keys getting hashed to the same bucket is $1/N$.

##### The MAD Method
* The MAD Method (Multiply-Add-and-Divide) is a more sophisticated compression function, which helps eliminate repeated patterns in a set of integer keys.
* This method maps an integer $i$ to $[(ai+b) mod p] mod N$, and $a$ and $b$ are integers chosen at random from the interval $[0, p-1]$, with $a>0$.
* This  compression function is chosen in order to eliminate repeated patterns in the set of hash codes and get us closer to having a good hash function.

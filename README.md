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
  1. Hash code - maos a key $k$ to an integer.
  2. Compression function - maps the has code to an integer within a range of indices, $[0, N - ]$ for a bucket array.
 
* 

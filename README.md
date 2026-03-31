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

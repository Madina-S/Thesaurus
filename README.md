# Thesaurus
Thesaurus implemented with binary tree, linked list and hash table

There is main class Dictionary. It has binary tree and hash table.

Binary tree stores all words and their corresponding key for the synonym.

Before insertion, the key is generated from the synonym. Using generated key, the word is placed in HashTable. HashTable element is HashNodeList, which is a simple linked list.

In remove, the word is searched in the tree and the key is gotten. If it is found, the word is removed from the tree and the HashNodeList in the corresponding key.

In search, the word is searched in the tree and the key is gotten. Then, the HashNodeList in the corrsponding key is returned. 

"""Linked stack data structure made with Python"""


class Stack:
    """Linked stack implementation"""
    head = None
    length = 0

    class __Node:
        prevNode = None

        def __init__(self, item, nextNode=None):
            """Initializes a new node with a item, pointing to
            a previous and next node if specified
            """
            self.item = item
            self.nextNode = nextNode

    class __StackIterator:
        """Iterator for linked stack"""

        def __init__(self, head):
            """Initializes with current head"""
            self.current = head

        def __next__(self):
            """Returns node and points to next node"""
            if not self.current:
                raise StopIteration
            item = self.current.item
            self.current = self.current.nextNode
            return item

    def push(self, item):
        """Adds a new item at the top"""
        self.length += 1
        if self.head:
            self.head.prevNode = self.__Node(item, nextNode=self.head)
            self.head = self.head.prevNode
        else:
            self.head = self.__Node(item)

    def pop(self):
        """Deletes first item and returns it"""
        if not self.head:
            raise IndexError('pop from empty stack')
        item = self.head.item
        self.head = self.head.nextNode
        if self.head:
            self.head.prevNode = None
        self.length -= 1
        return item

    def peek(self):
        """Shows first item"""
        if not self.head:
            raise IndexError('peek from empty stack')
        return self.head.item

    def __len__(self):
        """Returns stack length"""
        return self.length

    def __getitem__(self, index):
        """Gets item in specified node"""
        if index >= self.length:
            raise IndexError('stack index out of range')
        current = self.head
        for position in range(index + 1):
            if position == index:
                return current.item
            else:
                current = self.head.nextNode

    def __setitem__(self, index, item):
        """Sets item in specified node"""
        if index >= self.length:
            raise IndexError('stack index out of range')
        current = self.head
        for position in range(index + 1):
            if position == index:
                current.item = item
            else:
                current = self.head.nextNode

    def __delitem__(self, index):
        """Deletes value in specified index"""
        if index >= self.length:
            raise IndexError('stack index out of range')
        current = self.head
        for position in range(index + 1):
            if position == index:
                if index == 0:
                    self.head = current.nextNode
                if current.nextNode:
                    current.nextNode.prevNode = current.prevNode
                if current.prevNode:
                    current.prevNode.nextNode = current.nextNode
            else:
                current = current.nextNode
        self.length -= 1

    def __iter__(self):
        """Returns custom stack iterator"""
        return self.__StackIterator(self.head)

    def __str__(self):
        """Returns a string representacion of stack"""
        stack = '['
        current = self.head
        while True:
            if not current:
                return '[]'
            if current.nextNode:
                stack += '{item}, '.format(item=current.item)
                current = current.nextNode
            else:
                stack += '{item}]'.format(item=current.item)
                break
        return stack

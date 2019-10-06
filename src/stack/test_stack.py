"""Tests stack"""

import unittest

from stack import Stack


class StackTest(unittest.TestCase):
    """Tests stack methods"""

    def setUp(self):
        """Creates stack"""
        self.stack = Stack()

    def test_push(self):
        """Tests stack's push method"""
        self.assertEqual(len(self.stack), 0)
        self.stack.push('django')
        self.assertEqual(len(self.stack), 1)
        self.stack.push('flask')
        self.assertEqual(len(self.stack), 2)
        self.assertEqual(self.stack[1], 'django')
        self.assertEqual(self.stack[0], 'flask')

    def test_peek(self):
        """Tests stack's peek method"""
        self.stack.push('element')
        self.assertEqual('element', self.stack.peek())

        with self.assertRaises(IndexError):
            del self.stack[0]
            nothing = self.stack.peek()

    def test_pop(self):
        """Tests stack's pop method"""
        self.stack.push(1)
        self.stack.push(2)
        self.assertEqual(self.stack.pop(), 2)
        self.assertEqual(len(self.stack), 1)
        self.assertEqual(self.stack.pop(), 1)
        self.assertEqual(len(self.stack), 0)

        with self.assertRaises(IndexError):
            nothing = self.stack.pop()

    def test_iterator(self):
        """Tests iterator with a for"""
        for number in range(10):
            self.stack.push(number)
        counter = 9
        for item in self.stack:
            self.assertEqual(item, counter)
            counter -= 1

    def test_get_index_error(self):
        """Tests that accesing item raises exception"""
        with self.assertRaises(IndexError):
            nothing = self.stack[10]

    def test_set_item(self):
        """Tests item set"""
        with self.assertRaises(IndexError):
            self.stack[0] = 'Hola'

        self.stack.push(4)
        self.stack.push(2)
        self.stack.push(1)

        self.stack[2] = 3
        self.assertEqual(self.stack[2], 3)

    def test_delete_(self):
        """Tests delete magic method"""
        with self.assertRaises(IndexError):
            del self.stack[1]

        self.stack.push(3)
        self.stack.push(3)
        self.stack.push(2)
        self.stack.push(1)

        del self.stack[2]
        self.assertEqual(len(self.stack), 3)

        counter = 1
        for item in self.stack:
            self.assertEqual(item, counter)
            counter += 1

    def test_str(self):
        """Tests string method"""
        self.assertEqual(str(self.stack), '[]')
        self.stack.push(3)
        self.stack.push(2)
        self.stack.push(1)
        self.assertEqual(str(self.stack), '[1, 2, 3]')


if __name__ == '__main__':
    unittest.main()

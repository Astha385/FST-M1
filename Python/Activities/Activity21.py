import pytest

def test_addition():

    num1 = 21
    num2 = 11

    sum = num1 + num2

    assert sum == 32

def test_subtraction():

    num1 = 42
    num2 = 20

    diff = num1 - num2

    assert diff == 22

def test_multiplication():

    num1 = 15
    num2 = 5

    prod = num1 * num2

    assert prod == 75

def test_division():

    num1 = 500
    num2 = 25

    quot = num1 / num2

    assert quot == 20
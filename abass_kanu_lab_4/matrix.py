"""
This module allows user to play matrix game by entering their phone number and zip code.
Both phone and zip code are validated using regular expressions and user is only allowed
into matrix if the format of these is valid. After entry user enters two matrices to play
the game.
"""

import re
import numpy as np


def get_user_phone_number_and_zipcode():
    """
    Function to get and validate phone number and zip code.

    @rtype: String.
    @return: Phone number and zip code of the player.
    """
    phone_number = input("Enter your phone number (XXX-XXX-XXXX): ")
    phone_found = re.search("([0-9]{3})-([0-9]{3})-([0-9]{4})", phone_number)

    while phone_found is None:
        phone_number = input("Your phone number is not in format (XXX-XXX-XXXX), "
                             "please re-enter : ")
        phone_found = re.search("([0-9]{3})-([0-9]{3})-([0-9]{4})", phone_number)

    zip_code = input("Enter your zip code (XXXXX-XXXX): ")
    zip_found = re.search("([0-9]{5})-([0-9]{4})", zip_code)

    while zip_found is None:
        zip_code = input("Your zip code is not in format (XXXXX-XXXX), "
                         "please re-enter : ")
        zip_found = re.search("([0-9]{5})-([0-9]{4})", zip_code)

    return phone_number, zip_code


def get_user_matrices():
    """
    Function to get and validate matrices from user.

    @rtype: Tuple of numpy arrays.
    @return: Two matrices entered by the user as numpy arrays.
    """
    matrix_a = input("Enter your first 3x3 matrix: ").split(" ")
    while len(matrix_a) != 9:
        matrix_a = input("Your first 3x3 matrix does not contain 9 elements, "
                         "please re-enter: ").split(" ")

    matrix_b = input("Enter your second 3x3 matrix: ").split(" ")
    while len(matrix_b) != 9:
        matrix_b = input("Your second 3x3 matrix does not contain 9 elements, "
                         "please re-enter: ").split(" ")

    matrix_a = [float(i) for i in matrix_a]
    matrix_b = [float(i) for i in matrix_b]

    matrix_a = np.reshape(matrix_a, (3, 3))
    matrix_b = np.reshape(matrix_b, (3, 3))

    return matrix_a, matrix_b


def select_an_operation_to_perform_on_matrices():
    """
    Function to get and validate an operation selection from user.

    @rtype: String.
    @return: Selection of user.
    """
    print("Please select an operation to perform on matrices")
    print("a. Addition")
    print("b. Subtraction")
    print("c. Multiplication")
    print("d. Element multiplication")

    selection = input("Your selection: ")
    is_selection_valid = selection in ["a", "b", "c", "d"]

    while not is_selection_valid:
        selection = input("Please enter correct selection: ")
        is_selection_valid = selection in ["a", "b", "c", "d"]

    return selection


def perform_operation(matrix_a, matrix_b, selection):
    """
    Function to perform operation on two matrices.

    @param matrix_a: Numpy array.
    @param matrix_b: Numpy array.
    @param selection: String.
    @rtype: Numpy array or None.
    @return: Resultant matrix after performing operation or None.
    """
    if selection == "a":
        return np.add(matrix_a, matrix_b)

    if selection == "b":
        return np.subtract(matrix_a, matrix_b)

    if selection == "c":
        return np.matmul(matrix_a, matrix_b)

    if selection == "d":
        return np.multiply(matrix_a, matrix_b)

    return None


def print_result(resultant_matrix):
    """
    Function to print resultant matrix.

    @param resultant_matrix: Numpy array.
    """
    transpose_matrix = np.transpose(resultant_matrix)

    resultant_list = np.reshape(resultant_matrix, (9, ))
    transpose_list = np.reshape(transpose_matrix, (9, ))

    print(f"The results are {resultant_list}")
    print(f"The transpose is {transpose_list}")


def play_again():
    """
    Function to get input from user to play again.

    @rtype: Boolean.
    @return: True if user wants to play again else false.
    """
    print("Do you want to play the matrix game?")
    print("Y. Yes")
    print("N. No")

    selection = input("Your selection: ")
    is_selection_valid = selection in ["y", "Y", "n", "N"]

    while not is_selection_valid:
        selection = input("Please enter correct selection: ")
        is_selection_valid = selection in ["y", "Y", "n", "N"]

    return selection in ("Y", 'y')


def main():
    """
    Function to call all other functions.
    """
    while True:
        _, _ = get_user_phone_number_and_zipcode()
        matrix_a, matrix_b = get_user_matrices()
        selection = select_an_operation_to_perform_on_matrices()
        resultant_matrix = perform_operation(matrix_a, matrix_b, selection)
        print_result(resultant_matrix)

        again = play_again()
        if not again:
            break


if __name__ == '__main__':
    main()

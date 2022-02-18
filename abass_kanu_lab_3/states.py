"""
This module contains functions to perform different operations on the states-data.csv file.
It supports functionality to read data, display states in sorted order, update population,
search a state information and plot graphs.
"""
import os
import sys
import pandas as pd
import matplotlib.pyplot as plt
import matplotlib.image as img


def read_csv(filename):
    """
    Function to read csv file using pandas.
    :param filename: Path of the csv file.
    :return: Pandas dataframe.
    """
    return pd.read_csv(filename)


def print_menu():
    """
    Function to print menu.
    """
    print('Please select an option from the following:-')
    print('1. Display All States (Capital, Flower and Population) In Alphabetical Order')
    print('2. Search For A State')
    print('3. Plot Bar Graph Of 5 Most Populated States')
    print('4. Update Overall Population For A State')
    print('5. Exit')


def get_menu_input():
    """
    Function to get input from user for menu.
    :return: Selected option.
    """
    selection = int(input('Your selection: '))

    if selection < 1 or selection > 5:
        print('Invalid selection')
        sys.exit(64)

    return str(selection)


def display_all_states_in_alphabetical_order(states_df):
    """
    Function to display all states in sorted order.
    :param states_df: Pandas dataframe.
    """
    print(states_df.sort_values(by=['State']))
    return True


def search_for_a_state(states_df):
    """
    Function to search for a state and plot it's national flower picture.
    :param states_df: Pandas dataframe.
    """
    state_name = input('Please enter a state name: ').title()

    if not state_name:
        print('Please enter a valid state name')
        return

    image_paths = [os.path.join('flower-images', i) for i in os.listdir('flower-images')]
    images = [img.imread(image_path) for image_path in image_paths if state_name in image_path]

    for image in images:
        plt.imshow(image)

    print(states_df[states_df['State'].str.contains(state_name)])
    plt.show()
    return True


def plot_bar_graph_of_five_most_populated_states(states_df):
    """
    # Function to plot a bar graph of 5 most populated states.
    :param states_df: Pandas dataframe.
    """
    five_most_populated_states = states_df.sort_values(by=['Population'], ascending=False)[0:5]
    five_most_populated_states.plot(kind='bar', x='State', y='Population')
    plt.show()
    return True


def update_overall_population_of_a_state(states_df):
    """
    # Function to update overall population for a state.
    :param states_df: Pandas dataframe.
    """
    state_name = input('Please enter a state name: ').title()
    new_population = input('Please enter new population: ')
    states_df.loc[states_df['State'] == state_name, 'Population'] = int(new_population)
    print(states_df.loc[states_df['State'] == state_name])
    return True


def main():
    """
    # Pseudo main Function to call other functions.
    """
    states_df = read_csv('states-data.csv')

    while True:
        print_menu()
        menu_input = get_menu_input()

        if menu_input == '1':
            display_all_states_in_alphabetical_order(states_df)

        if menu_input == '2':
            search_for_a_state(states_df)

        if menu_input == '3':
            plot_bar_graph_of_five_most_populated_states(states_df)

        if menu_input == '4':
            update_overall_population_of_a_state(states_df)

        if menu_input == '5':
            print('Thanks for visiting our application')
            sys.exit(0)


if __name__ == '__main__':
    main()

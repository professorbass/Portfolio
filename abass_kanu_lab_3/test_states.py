import states
from unittest import TestCase


class TestStates(TestCase):
    df = states.read_csv('states-data.csv')

    def test_display_all_states_in_alphabetical_order(self):
        status = states.display_all_states_in_alphabetical_order(self.df)
        assert status is True

    def test_search_for_a_state(self):
        status = states.search_for_a_state(self.df)
        assert status is True

    def test_plot_bar_graph_of_five_most_populated_states(self):
        status = states.plot_bar_graph_of_five_most_populated_states(self.df)
        assert status is True

    def test_update_overall_population_of_a_state(self):
        status = states.update_overall_population_of_a_state(self.df)
        assert status is True

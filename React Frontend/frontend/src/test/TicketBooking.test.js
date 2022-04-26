import React from 'react';
import renderer from 'react-test-renderer';
import TicketBooking from '../components/TicketBooking'

const mockedUsedNavigate = jest.fn();
jest.mock('react-router-dom', () => ({
    ...jest.requireActual('react-router-dom'), Link: () => mockedUsedNavigate,

}));

afterAll(() => {
    jest.clearAllMocks();
});

it('renders correctly', () => {
    const tree = renderer
        .create(<TicketBooking/>)
        .toJSON();
    console.log(tree)

    expect(tree).toMatchSnapshot();

});
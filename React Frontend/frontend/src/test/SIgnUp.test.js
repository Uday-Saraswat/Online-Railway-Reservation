import React from 'react';
import renderer from 'react-test-renderer';
import SignUp from '../components/SignUp'

const mockedUsedNavigate = jest.fn();
jest.mock('react-router-dom', () => ({
    ...jest.requireActual('react-router-dom'), Link: () => mockedUsedNavigate,

}));

afterAll(() => {
    jest.clearAllMocks();
});

it('renders correctly', () => {
    const tree = renderer
        .create(<SignUp/>)
        .toJSON();
    console.log(tree)

    expect(tree).toMatchSnapshot();

});
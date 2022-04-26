import React from 'react';
import renderer from 'react-test-renderer';
import TrainList from '../components/TrainList'

const mockedUsedNavigate = jest.fn();
jest.mock('react-router-dom', () => ({
    ...jest.requireActual('react-router-dom'), Link: () => mockedUsedNavigate,

}));

afterAll(() => {
    jest.clearAllMocks();
});

it('renders correctly', () => {
    const tree = renderer
        .create(<TrainList/>)
        .toJSON();
    console.log(tree)

    expect(tree).toMatchSnapshot();

});
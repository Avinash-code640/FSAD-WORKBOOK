import { render, screen } from '@testing-library/react';
import App from './App';

<<<<<<< HEAD
test('renders learn react link', () => {
  render(<App />);
  const linkElement = screen.getByText(/learn react/i);
  expect(linkElement).toBeInTheDocument();
=======
test('renders student manager heading', () => {
  render(<App />);
  const headingElement = screen.getByRole('heading', { name: /student manager/i });
  expect(headingElement).toBeInTheDocument();
>>>>>>> 3f37b73e12a3b9104df6181bfc1461a38225067a
});

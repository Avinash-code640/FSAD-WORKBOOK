import { render, screen } from '@testing-library/react';
import App from './App';

test('renders student manager heading', () => {
  render(<App />);
  const headingElement = screen.getByRole('heading', { name: /student manager/i });
  expect(headingElement).toBeInTheDocument();
});

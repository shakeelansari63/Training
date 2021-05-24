// This is list of fake/mocked tasks
// We need a model for these tasks without that it won't know what column is what.
import { Task } from './Task'

// Define mock data
export const TASKS: Task[] = [
    {
      id: 1,
      text: 'Doctors Appointment',
      day: 'May 5th at 2:30pm',
      reminder: true,
    },
    {
      id: 2,
      text: 'Meeting at School',
      day: 'May 6th at 1:30pm',
      reminder: true,
    },
    {
      id: 3,
      text: 'Food Shopping',
      day: 'May 7th at 12:30pm',
      reminder: false,
    },
  ];
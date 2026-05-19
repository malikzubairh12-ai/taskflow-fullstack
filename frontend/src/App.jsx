import React, { useEffect, useState } from 'react';
import { createRoot } from 'react-dom/client';
import './style.css';

const API = 'http://localhost:8080/api/tasks';

function App() {
  const [tasks, setTasks] = useState([]);
  const [stats, setStats] = useState({ total: 0, todo: 0, inProgress: 0, done: 0 });
  const [form, setForm] = useState({ title: '', description: '', status: 'TODO', priority: 'MEDIUM', dueDate: '' });
  const load = async () => { setTasks(await (await fetch(API)).json()); setStats(await (await fetch(`${API}/stats`)).json()); };
  useEffect(() => { load(); }, []);
  const submit = async (e) => { e.preventDefault(); await fetch(API, { method: 'POST', headers: { 'Content-Type': 'application/json' }, body: JSON.stringify(form) }); setForm({ title: '', description: '', status: 'TODO', priority: 'MEDIUM', dueDate: '' }); load(); };
  const remove = async (id) => { await fetch(`${API}/${id}`, { method: 'DELETE' }); load(); };
  return <main className="container">
    <h1>TaskFlow</h1><p className="subtitle">Fullstack Java + React portfolio project</p>
    <section className="stats"><div>Total: {stats.total}</div><div>Todo: {stats.todo}</div><div>In Progress: {stats.inProgress}</div><div>Done: {stats.done}</div></section>
    <form onSubmit={submit} className="card form">
      <input placeholder="Task title" value={form.title} onChange={e=>setForm({...form,title:e.target.value})}/>
      <input placeholder="Description" value={form.description} onChange={e=>setForm({...form,description:e.target.value})}/>
      <select value={form.status} onChange={e=>setForm({...form,status:e.target.value})}><option>TODO</option><option>IN_PROGRESS</option><option>DONE</option></select>
      <select value={form.priority} onChange={e=>setForm({...form,priority:e.target.value})}><option>LOW</option><option>MEDIUM</option><option>HIGH</option></select>
      <input type="date" value={form.dueDate} onChange={e=>setForm({...form,dueDate:e.target.value})}/>
      <button>Add Task</button>
    </form>
    <section className="grid">{tasks.map(t => <article className="card" key={t.id}><h3>{t.title}</h3><p>{t.description}</p><small>{t.status} | {t.priority} | {t.dueDate}</small><button onClick={()=>remove(t.id)}>Delete</button></article>)}</section>
  </main>;
}

createRoot(document.getElementById('root')).render(<App/>);

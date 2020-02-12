import React, { Component } from 'react';
import SingleTask from './SingleTask';
import AddTasks from './AddTasks';

export default class Tasks extends Component {
    constructor(props) {
        super(props);
        this.state = {
            tasks: [],
        };
    }

    componentDidMount() {
        fetch('http://localhost:8080/api/tasks')
            .then(response => response.json())
            .then(data => this.setState({tasks: data}))
    }

    render() {
        return (
            <div>
                <div className="row">
                    <AddTasks />
                </div>
                <div className="row">
                    { this.state.tasks.map((item) => (
                        <SingleTask item={item} />
                    ))}
                </div>
            </div>
        )
    }
}

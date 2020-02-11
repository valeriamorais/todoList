import React from 'react';

const SingleTask = ({item}) => (
    <div className="row">
        <div className="col s12 m6">
            <div className="card blue-grey darken-1">
                <div className="card-content white-text">
                    <span className="card-title">{item.id} {item.taskName}</span>
                </div>
            </div>
        </div>
    </div>
);

export default SingleTask;
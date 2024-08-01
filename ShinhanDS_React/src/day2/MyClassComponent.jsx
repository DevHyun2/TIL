import "day1/external.css";
import { Component } from 'react';
import Button from 'react-bootstrap/Button';

export default class MyClassComponent extends Component {
  render() {
    const inlineStyle = {border : "1px solid orange", color:"gray"};
    const {subject, score, children} = this.props;
    return (
      <div style={inlineStyle}>
        <h1 style={{backgroundColor:"lightsalmon"}}>ClassComponent 리뷰</h1>
        <hr/>
        <h1 className='myStyle2'>외부 css import</h1>
        <p>속성받기 subject: {this.props.subject}</p>
        <p>속성받기 subject: {subject}</p>
        <p>속성받기 score: {this.props.score}</p>
        <p>속성받기 score: {score}</p>
        <p>태그사이의 내용 children: {this.props.children}</p>
        <p>태그사이의 내용 children: {children}</p>
        <Button variant="primary">Primary</Button>{' '}
        <Button variant="secondary">Secondary</Button>{' '}
        <Button variant="success">Success</Button>{' '}
        <Button variant="warning">Warning</Button>{' '}
        <Button variant="danger">Danger</Button>{' '}
        <Button variant="info">Info</Button>{' '}
        <Button variant="light">Light</Button>{' '}
        <Button variant="dark">Dark</Button>
        <Button variant="link">Link</Button>
      </div>
    );
  }
}
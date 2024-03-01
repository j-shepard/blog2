import React, { useState } from 'react';
import axios from 'axios';

function App() {
  const [uuid, setUuid] = useState(null);
  
  // send POST request when component mounts
  React.useEffect(() => {
    async function fetchData() {
      try {
        const response = await axios({
          method: 'post',
          url: '/api/v1/insertinformation',
          data: {
            description: 'Some Description',
            jsonData: '{"key": "value"}'
          }
        });
        setUuid(response.data);  // assuming UUID is returned in the response body
      } catch (error) {
        console.error('Error fetching data: ', error);
      }
    }
  
    fetchData();
  }, []);

  return (
    <div className="App">
      <header className="App-header">
        <p>UUID: {uuid}</p>  // display UUID returned from server
      </header>
    </div>
  );
}

export default App;

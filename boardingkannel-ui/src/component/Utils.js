export default class Utils {
  static post(path, postData) {
    return (fetch(path, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(postData),
    })
      .then(response => response.json())
      // .then(data => {
      //   console.log('Success:', data);
      // })
      .catch((error) => {
        console.error('Error:', error);
      }))
  }

  static get (path) {
   return (fetch (path, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then(response => response.json())
      
      .catch((error) => {
        console.error('Error:', error);
    })
   ) 
  }
}


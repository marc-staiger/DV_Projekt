
console.log("ready")

async function main()
{
	//--- getting data from the server ---//
	let data = await (await fetch("/getdata")).json()
	console.log(data)

	//--- handling button click ---//
	let btn = document.getElementById("btnSend")
	btn.onclick = async ev =>
	{
		//--- posting data to the server ---//
		let response = await fetch("/postdata", {
			method: 'POST',
			headers: { 'Content-Type': 'application/json' },
			body: JSON.stringify({"value": "OK"}) // body data type must match "Content-Type" header
		});
		console.log("HTTP status code:", response.status)
		if (response.status==200) alert("Server successfully acknowledged")
		else alert("There was an error connecting to the server")
	}
}
main()
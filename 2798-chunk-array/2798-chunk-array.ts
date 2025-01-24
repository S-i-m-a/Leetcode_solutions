// Function to split an array into chunks of a specified size
function chunk(array: any[], size: number): any[][] {
    const chunks: any[][] = []; // Initialize an empty array to hold the chunks

    // Loop through the array, incrementing by 'size' on each iteration
    for (let i = 0, arrayLength = array.length; i < arrayLength; i += size) {
        // Slice the array from the current index 'i' up to 'i + size'
        // and push this new chunk into the 'chunks' array
        chunks.push(array.slice(i, i + size));
    }

    return chunks; // Return the array of chunks
}

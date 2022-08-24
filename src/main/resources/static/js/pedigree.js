function getPedigree(id) {
    fetch("/pedigree/" + id)
        .then(res => res.json())
        .then(data => {
            console.log(data);
            var config = {
                    container: "#OrganiseChart1",
                    rootOrientation: 'WEST', // NORTH || EAST || WEST || SOUTH
                    levelSeparation: 30,
                    siblingSeparation: 20,
                    subTeeSeparation: 60,
                    scrollbar: "fancy",

                    connectors: {
                        type: 'step'
                    },
                    node: {
                        HTMLclass: 'nodeExample1'
                    }
                },
                goat = {
                    text: {
                        name: data.name,
                        breed: data.breed,
                        sex: data.sex,
                        dob: new Date(data.dob).toLocaleDateString()
                    },
                    link: {
                        href: "/goat/" + data.id,
                        target: "_blank"
                    },
                    image: "../headshots/2.jpg",
                    HTMLid: "goat"
                },

                parent1 = {
                    parent: goat,
                    text: {
                        name: data.parents[0]?.name === undefined ? "Unknown" : data.parents[0].name,
                        breed: data.parents[0]?.breed === undefined ? "" : data.parents[0].breed,
                        sex: data.parents[0]?.sex === undefined ? "" : data.parents[0].sex,
                        dob: data.parents[0]?.dob === undefined ? "" : new Date(data.parents[0]?.dob).toLocaleDateString()
                    },
                    link: {
                        href: data.parents[0]?.id === undefined ? "" : "/goat/" + data.parents[0]?.id,
                        target: "_blank"
                    },
                    image: "../headshots/1.jpg",
                    HTMLid: "coo"
                },
                parent2 = {
                    parent: goat,
                    text: {
                        name: data.parents[1]?.name === undefined ? "Unknown" : data.parents[1].name,
                        breed: data.parents[1]?.breed === undefined ? "" : data.parents[1].breed,
                        sex: data.parents[1]?.sex === undefined ? "" : data.parents[1].sex,
                        dob: data.parents[1]?.dob === undefined ? "" : new Date(data.parents[1]?.dob).toLocaleDateString()
                    },
                    link: {
                        href: data.parents[1]?.id === undefined ? "" : "/goat/" + data.parents[1].id,
                        target: "_blank"
                    },
                    image: "../headshots/5.jpg",
                    HTMLid: "parent2"
                },
                grandParent11 = {
                    parent: parent1,
                    text: {
                        name: data.parents[0]?.parents[0]?.name === undefined ? "Unknown" : data.parents[0].parents[0].name,
                        breed: data.parents[0]?.parents[0]?.breed === undefined ? "" : data.parents[0].parents[0].breed,
                        sex: data.parents[0]?.parents[0]?.sex === undefined ? "" : data.parents[0].parents[0].sex,
                        dob: data.parents[0]?.parents[0]?.dob === undefined ? "" : new Date(data.parents[0]?.parents[0].dob).toLocaleDateString()
                    },
                    link: {
                        href: data.parents[0]?.parents[0]?.id === undefined ? "" : "/goat/" + data.parents[0].parents[0].id,
                        target: "_blank"
                    },
                    image: "../headshots/8.jpg",
                    HTMLid: "grandParent11"
                },
                grandParent12 = {
                    parent: parent1,
                    text: {
                        name: data.parents[0]?.parents[1]?.name === undefined ? "Unknown" : data.parents[0].parents[1].name,
                        breed: data.parents[0]?.parents[1]?.breed === undefined ? "" : data.parents[0].parents[1].breed,
                        sex: data.parents[0]?.parents[1]?.sex === undefined ? "" : data.parents[0].parents[1].sex,
                        dob: data.parents[0]?.parents[1]?.dob === undefined ? "" : new Date(data.parents[0]?.parents[1].dob).toLocaleDateString()
                    },
                    link: {
                        href: data.parents[0]?.parents[1]?.id === undefined ? "" : "/goat/" + data.parents[0].parents[1].id,
                        target: "_blank"
                    },
                    image: "../headshots/9.jpg",
                    HTMLid: "grandParent12"
                },
                grandParent21 = {
                    parent: parent2,
                    text: {
                        name: data.parents[1]?.parents[0]?.name === undefined ? "Unknown" : data.parents[1].parents[0].name,
                        breed: data.parents[1]?.parents[0]?.breed === undefined ? "" : data.parents[1].parents[0].breed,
                        sex: data.parents[1]?.parents[0]?.sex === undefined ? "" : data.parents[1].parents[0].sex,
                        dob: data.parents[1]?.parents[0]?.dob === undefined ? "" : new Date(data.parents[1]?.parents[0].dob).toLocaleDateString()
                    },
                    link: {
                        href: data.parents[1]?.parents[0]?.id === undefined ? "" : "/goat/" + data.parents[1].parents[0].id,
                        target: "_blank"
                    },
                    image: "../headshots/4.jpg",
                    HTMLid: "grandParent21"
                },
                grandParent22 = {
                    parent: parent2,
                    text: {
                        name: data.parents[1]?.parents[1]?.name === undefined ? "Unknown" : data.parents[1].parents[1].name,
                        breed: data.parents[1]?.parents[1]?.breed === undefined ? "" : data.parents[1].parents[1].breed,
                        sex: data.parents[1]?.parents[1]?.sex === undefined ? "" : data.parents[1].parents[1].sex,
                        dob: data.parents[1]?.parents[1]?.dob === undefined ? "" : new Date(data.parents[1]?.parents[1].dob).toLocaleDateString()
                    },
                    link: {
                        href: data.parents[1]?.parents[1]?.id === undefined ? "" : "/goat/" + data.parents[1].parents[1].id,
                        target: "_blank"
                    },
                    image: "../headshots/11.jpg",
                    HTMLid: "grandParent22"
                }

            ALTERNATIVE = [
                config,
                goat,
                parent1,
                parent2,
                grandParent11,
                grandParent12,
                grandParent21,
                grandParent22
            ];
            new Treant(ALTERNATIVE);
        });
}
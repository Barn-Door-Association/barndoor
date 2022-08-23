function getPedigree (id) {
fetch("/pedigree/" + id)
    .then(res => res.json())
    .then(data => {
        console.log(data);
        var config = {
                container: "#OrganiseChart1",
                rootOrientation: 'WEST', // NORTH || EAST || WEST || SOUTH
                // levelSeparation: 30,
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
                },
                image: "../headshots/2.jpg",
                HTMLid: "goat"
            },

            parent1 = {
                parent: goat,
                text: {
                    name: data.parent[0].name,
                    title: "Chief Technology Officer",
                },
                // stackChildren: true,
                image: "../headshots/1.jpg",
                HTMLid: "coo"
            },
            parent2 = {
                parent: goat,
                text: {
                    name: "Linda May",
                    title: "Chief Business Officer",
                },
                image: "../headshots/5.jpg",
                HTMLid: "parent2"
            },
            // cdo = {
            //     parent: parent1,
            //     text: {
            //         name: "John Green",
            //         title: "Chief accounting officer",
            //         contact: "Tel: 01 213 123 134",
            //     },
            //     image: "../headshots/6.jpg",
            //     HTMLid: "cdo"
            // },

            cio = {
                parent: parent1,
                text: {
                    name: "Ron Blomquist",
                    title: "Chief Information Security Officer"
                },
                image: "../headshots/8.jpg",
                HTMLid: "cio"
            },
            ciso = {
                parent: parent1,
                text: {
                    name: "Michael Rubin",
                    title: "Chief Innovation Officer",
                    contact: "we@aregreat.com"
                },
                image: "../headshots/9.jpg",
                HTMLid: "ciso"
            },
            // cio2 = {
            //     parent: parent1,
            //     text: {
            //         name: "Erica Reel",
            //         title: "Chief Customer Officer"
            //     },
            //     link: {
            //         href: "http://www.google.com",
            //         target: "_blank"
            //     },
            //     image: "../headshots/10.jpg",
            //     HTMLid: "cio2"
            // },

            // ciso2 = {
            //     parent: parent2,
            //     text: {
            //         name: "Alice Lopez",
            //         title: "Chief Communications Officer"
            //     },
            //     image: "../headshots/7.jpg",
            //     HTMLid: "ciso2"
            // },
            ciso3 = {
                parent: parent2,
                text: {
                    name: "Mary Johnson",
                    title: "Chief Brand Officer"
                },
                image: "../headshots/4.jpg",
                HTMLid: "ciso2"
            },
            ciso4 = {
                parent: parent2,
                text: {
                    name: "Kirk Douglas",
                    title: "Chief Business Development Officer"
                },
                image: "../headshots/11.jpg",
                HTMLid: "ciso2"
            }

        ALTERNATIVE = [
            config,
            goat,
            parent1,
            parent2,
            // cdo,
            cio,
            ciso,
            // cio2,
            // ciso2,
            ciso3,
            ciso4
        ];
        new Treant( ALTERNATIVE );
    });
}
$(function () {
    function printTable(array) {
        for (var i = 0; i < array.length; i++) {
            console.log(array[i]);
        }
    }

    $('#button').on('click', function (e) {
        e.preventDefault();
        var div = document.getElementsByClassName("exercise")
        let listOfSets = [];

        // function userExerciseDTO(exerciseName, exerciseId) {
        //     this.exerciseName = exerciseName;
        //     this.exerciseId = exerciseId
        // }

        for (var i = 0; i < div.length; i++) {
            var userExerciseDTO = {}
            var newSetsDTO = {}
            var sets = []
            var exerciseName = div[i].getElementsByClassName('exerciseName')[0].value
            var exerciseId = div[i].getElementsByClassName('exerciseId')[0].value
            var weight = div[i].querySelectorAll('#weight')
            var reps = div[i].querySelectorAll('#reps')
            var rpe = div[i].querySelectorAll('#rpe')
            var tempo = div[i].querySelectorAll('#tempo')
            for (var j = 0; j < reps.length; j++) {

                newSetsDTO.weight = weight[j].value
                newSetsDTO.reps = reps[j].value
                newSetsDTO.rpe = rpe[j].value
                newSetsDTO.tempo = tempo[j].value
                sets.push(newSetsDTO)
            }


            // console.log(reps)
            // console.log(exerciseName)
            // console.log(exerciseId)
            userExerciseDTO.exerciseName = exerciseName;
            userExerciseDTO.exerciseId = exerciseId;
            userExerciseDTO.sets = sets;
            // console.log(userExerciseDTO)
            listOfSets.push(userExerciseDTO)
        }
        printTable(listOfSets)
        // var form = document.getElementById("formData")
        // // var form=$('#formData')
        // console.log(form)
        // var exerciseName = document.getElementsByName('exerciseName')
        // printTable(exerciseName)
        // var data=new FormData(form)
        // console.log(data)
        // for (var pair of data.entries())
        // {
        //     console.log(pair[0]+ ', '+ pair[1]);
        // }
        // var  exerciseName = $('.exerciseName').val();
        // var exerciseId = $('.exerciseId').val()
        // console.log(exerciseId);
        // console.log(exerciseName);
        //
        // // let sets = new Map();
        // function userExerciseDTO(exerciseName, exerciseId) {
        //     this.exerciseName = exerciseName;
        //     this.exerciseId = exerciseId
        // }
        //
        // let listOfSets = [];
        var newTrainingDTO = {
            trainingSessionId: $('#trainingSessionId').val(),
            listOfSets: listOfSets
            // listOfSets: listOfSets.push(new userExerciseDTO($('exerciseName').val(), $('exerciseId').val()))
            // sets: sets.set($('#exerciseName').val(), $('reps').val())
        }
        // //   var form=$('#formData')
        // //   console.log(form)
        // //   var data=new FormData(form)
        // //   console.log(data)
        // console.log(JSON.stringify(Object.fromEntries(data)))
        console.log(newTrainingDTO)
        // newTrainingDTO.listOfSets.forEach(function (item) {
        //     console.log(item)
        // })
        var token = $('#csrfToken').val();
        var header = $('#csrfHeader').val();
        $.ajax({
            async: false,
            url: 'http://localhost:8080/user/performTraining/'+newTrainingDTO.trainingSessionId,
            // type: 'POST',
            method: 'POST',
            data: {"json": JSON.stringify(newTrainingDTO)},
            contentType: "application/json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
                xhr.setRequestHeader(header, token);
            },
            success: function (data) {
                window.location.href = 'http://localhost:8080/user/performTraining/'+newTrainingDTO.trainingSessionId
            }
        })
        //     .done(function (result) {
        //
        // })
    })
})
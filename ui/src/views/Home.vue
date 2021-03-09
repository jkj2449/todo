<template>
  <div>
    <v-card>
      <v-card-title>
        Nutrition
        <v-spacer></v-spacer>
        <v-text-field
          v-model="search"
          append-icon="mdi-magnify"
          label="Search"
          single-line
          hide-details
        ></v-text-field>
      </v-card-title>
      <v-data-table
        @click="rowClick"
        :headers="headers"
        :items="boards"
        :search="search"
        loading-text="Loading... Please wait"
      >
        <template v-slot:item="{item}">
          <tr @click="rowClick(item)">
            <td class="text-xs-right">{{item.id}}</td>
            <td class="text-xs-right">{{item.content}}</td>
            <td class="text-xs-right">{{item.author}}</td>
            <td class="text-xs-right">{{item.createdBy}}</td>
          </tr>
        </template>
      </v-data-table>
    </v-card>

    <v-layout row wrap justify-end mt-5 mr-5>
      <v-flex shrink>
        <v-btn color="primary" router :to="{name: 'write'}" exact>Write</v-btn>
      </v-flex>
    </v-layout>
    

  </div>
</template>

<script>

export default {
  name: 'Home',
  created() {
    this.$http.get('/api/v1/post', {

    }).then(response => {

    }).catch(ßerror => {

    })
  },
  data() {
    return {
      search: "",
      headers: [       
          { text: '번호', value: 'id' },
          { text: '내용', value: 'content' },
          { text: '작성자', value: 'author' },
          { text: '작성날짜', value: 'createdBy' },
        ],
      boards: [
        {
          id: 1,
          content: "content",
          author: "tester",
          createdBy: "2020-06-01 12:00:00"
        }
      ]
    }
  },
  methods: {
    rowClick() {
      alert('test');
    }
  }
}
</script>

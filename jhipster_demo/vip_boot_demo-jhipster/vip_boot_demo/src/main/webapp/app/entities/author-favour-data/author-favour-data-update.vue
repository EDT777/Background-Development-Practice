<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="vip1App.authorFavourData.home.createOrEditLabel" v-text="$t('vip1App.authorFavourData.home.createOrEditLabel')">Create or edit a AuthorFavourData</h2>
                <div>
                    <div class="form-group" v-if="authorFavourData.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="authorFavourData.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.authorFavourData.userId')" for="author-favour-data-userId">User Id</label>
                        <input type="number" class="form-control" name="userId" id="author-favour-data-userId"
                            :class="{'valid': !$v.authorFavourData.userId.$invalid, 'invalid': $v.authorFavourData.userId.$invalid }" v-model.number="$v.authorFavourData.userId.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.authorFavourData.createDate')" for="author-favour-data-createDate">Create Date</label>
                        <div class="d-flex">
                            <input id="author-favour-data-createDate" type="datetime-local" class="form-control" name="createDate" :class="{'valid': !$v.authorFavourData.createDate.$invalid, 'invalid': $v.authorFavourData.createDate.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.authorFavourData.createDate.$model)"
                            @change="updateZonedDateTimeField('createDate', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.authorFavourData.author')" for="author-favour-data-author">Author</label>
                        <select class="form-control" id="author-favour-data-author" name="author" v-model="authorFavourData.authorId">
                            <option v-bind:value="null"></option>
                            <option v-bind:value="authorOption.id" v-for="authorOption in authors" :key="authorOption.id">{{authorOption.id}}</option>
                        </select>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.authorFavourData.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./author-favour-data-update.component.ts">
</script>
